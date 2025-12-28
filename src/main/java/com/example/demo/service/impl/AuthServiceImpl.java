@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userRepo;
    private final RoleRepository roleRepo;
    private final UserRoleRepository userRoleRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(
            UserAccountRepository userRepo,
            RoleRepository roleRepo,
            UserRoleRepository userRoleRepo,
            PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.userRoleRepo = userRoleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(RegisterRequestDto request) {

        if (userRepo.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        // 1️⃣ Create user
        UserAccount user = new UserAccount();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        userRepo.save(user);

        // 2️⃣ Assign DEFAULT role = USER
        Role role = roleRepo.findByRoleName("USER")
                .orElseThrow(() -> new RuntimeException("Default role USER not found"));

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRole.setActive(true);
        userRole.setAssignedAt(LocalDateTime.now());

        userRoleRepo.save(userRole);
    }
}

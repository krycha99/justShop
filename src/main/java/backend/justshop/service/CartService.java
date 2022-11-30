package backend.justshop.service;

import backend.justshop.repository.CartRepository;
import backend.justshop.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {

    private final UserService userService;

    private final CartRepository cartRepository;
}

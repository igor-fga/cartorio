package br.com.igor.cartorio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igor.cartorio.model.Cartorio;
import br.com.igor.cartorio.repository.CartorioRepository;

@Service
public class CartorioServiceImpl implements CartorioService {

	@Autowired
	private CartorioRepository cartorioRepository;

	@Override
	public Cartorio saveCartorio(Cartorio cartorio) {
		return cartorioRepository.save(cartorio);
	}

	@Override
	public List<Cartorio> getAllCartorios() {
		return cartorioRepository.findAll();
	}

	@Override
	public Cartorio getCartorioById(Long id) {
		Optional<Cartorio> cartorioOptional = cartorioRepository.findById(id);
		Cartorio cartorio = null;

		if (cartorioOptional.isPresent()) {
			cartorio = cartorioOptional.get();
		} else {
			throw new RuntimeException("Cartorio Id not found: " + id);
		}

		return cartorio;
	}

	@Override
	public void deleteCartorioById(Long id) {
		cartorioRepository.deleteById(id);
	}

}

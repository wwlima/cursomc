package br.com.w2tec.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.w2tec.cursomc.domain.Categoria;
import br.com.w2tec.cursomc.domain.Cidade;
import br.com.w2tec.cursomc.domain.Cliente;
import br.com.w2tec.cursomc.domain.Endereco;
import br.com.w2tec.cursomc.domain.Estado;
import br.com.w2tec.cursomc.domain.Produto;
import br.com.w2tec.cursomc.domain.enums.TipoCliente;
import br.com.w2tec.cursomc.repositories.CategoriaRepository;
import br.com.w2tec.cursomc.repositories.CidadeRepository;
import br.com.w2tec.cursomc.repositories.ClienteRepository;
import br.com.w2tec.cursomc.repositories.EnderecoRepository;
import br.com.w2tec.cursomc.repositories.EstadoRepository;
import br.com.w2tec.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Incluindo categorias
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		// Incluindo produtos		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		//Vinculando produtos a categorias
		c1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		
		//Vinculando categorias a produto
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
				
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Uberlandia", est1);
		Cidade cidade2 = new Cidade(null, "São Paulo", est2);
		Cidade cidade3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cidade1));
		est2.getCidades().addAll(Arrays.asList(cidade2,cidade3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "111111111", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("2222-2222","3333-3333"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto203","jardim",	"38220824", cli1, cidade1);
		Endereco e2 = new Endereco(null, "Av Matos", "105", "Sala 800","Centro",	"38777012", cli1, cidade2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}
}

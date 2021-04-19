package prjFuncional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Conceito de paradigma funcional
		UnaryOperator<Long> calcNumTest = valor -> valor * 2;
		Long result = calcNumTest.apply(2l);
		System.out.println("resultado : "+result);

		//funções devem ser puras com parâmetros imutáveis
		//trabalhando com arrays no paradigma funcional
		int[] valores = {1,2,3,4};
		Arrays.stream(valores)
			.filter(num -> num % 2 == 0)
			.map(num -> num * 2)
			.forEach(num -> System.out.println(num));
		
		//imutabilidade
		String nomeOriginal = "test";
		UnaryOperator<String> toUpper = value -> value.toUpperCase();
		System.out.println(toUpper.apply(nomeOriginal)); //apenas retorna um novo String
		System.out.println(nomeOriginal); //veja que não foi alterado
		
		Function<Integer, Object> buscarPorId = id -> { return new Object(); };
		System.out.println(buscarPorId.apply(999));
		
		/** InterfaceFuncional nomeVariavel = parametro -> logica */
		Funcao testeFncInterface = valor -> valor.toLowerCase();
		System.out.println(
				testeFncInterface.gerar("TESTE"));
		
		
		List<Usuario> users = Arrays.asList(new Usuario("Ana", "F"), new Usuario("João", "M"));
		
		Function<Usuario, String> fncTratamento = usuario -> usuario.getSexo().equalsIgnoreCase("F")?"Sra. ":"Sr.";
		
		users.stream()
			.map(usuario -> {
				usuario.setNome(fncTratamento.apply(usuario) + usuario.getNome());
				return usuario;
			})
			.forEach(user -> System.out.println(user.getNome()));
		
		users.forEach(usu -> System.out.println(usu.getNome())); 
		
		
		//Consumer - É uma interface funcional que não retorna um valor
		//Consumer<String> imprime = valor -> System.out.println(valor);
		Consumer<String> imprime = System.out::println;
		imprime.accept("Olá");
		
		
		//Predicate - faz um teste e retorna um valor boleano
		//Predicate<String> vazio = valor -> valor.isEmpty();
		Predicate<String> vazio = String::isEmpty;
		System.out.println(vazio.test("coisa")?"vazio":"tem coisa");
		
		
		//Supplier<Usuario> userSup = () -> new Usuario("Adatolilde", "M");
		Supplier<Usuario> userSup = Usuario::new;
		
		Usuario novoUser = userSup.get();
		imprime.accept(novoUser.toString());
		
		
		//Stream -> É uma classe abstrata
		String nomes[] = {"João", "Maria", "Adatolilde"};
		String filtrados = Stream.of(nomes).filter(nome -> nome.contains("a")).collect(Collectors.joining(" "));
		System.out.println(filtrados);
		
		//Stream.of(nomes).forEach(System.out::println);
		Stream.of(nomes).forEach(nome -> System.out.println(nome + " de Tal"));
		
		
	}

}

import java.io.IOException;

public class Main {

	public static void main(String args[]) throws IOException
	{
		OrdenacaoTopologica ord = new OrdenacaoTopologica();
		
		String nomeEntrada = "texto.txt";
		
		ord.realizaLeitura(nomeEntrada);
		ord.debug();

//		if(!ord.executa())
//			System.out.println("O conjunto nao � parcialmente ordenado.");
//		else
//			System.out.println("O conjunto � parcialmente ordenado.");
	}
}

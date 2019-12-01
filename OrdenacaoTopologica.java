import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrdenacaoTopologica
{
	private class Elo
	{
		/* Identifica��o do elemento. */
		public int chave;
		
		/* N�mero de predecessores. */
		public int contador;
		
		/* Aponta para o pr�ximo elo da lista. */
		public Elo prox;
		
		/* Aponta para o primeiro elemento da lista de sucessores. */
		public EloSuc listaSuc;
		
		public Elo()
		{
			prox = null;
			contador = 0;
			listaSuc = null;
		}
		
		public Elo(int chave, int contador, Elo prox, EloSuc listaSuc)
		{
			this.chave = chave;
			this.contador = contador;
			this.prox = prox;
			this.listaSuc = listaSuc;
		}
	}
	
	private class EloSuc
	{
		/* Aponta para o elo que � sucessor. */
		public Elo id;
		
		/* Aponta para o pr�ximo elemento. */
		public EloSuc prox;
		
		public EloSuc()
		{
			id = null;
			prox = null;
		}
		
		public EloSuc(Elo id, EloSuc prox)
		{
			this.id = id;
			this.prox = prox;
		}
	}


	/* Ponteiro (refer�ncia) para primeiro elemento da lista. */
	private Elo prim;
	/*Ponteiro (refer�ncia) para �ltimo elemento da lista.*/
	private Elo ult;
	
	/* N�mero de elementos na lista. */
	private int n;
		
	public OrdenacaoTopologica()
	{
		prim = null;
		n = 0;
	}
	
	/* M�todo respons�vel pela leitura do arquivo de entrada. */
	public void realizaLeitura(String nomeEntrada) throws IOException
	{
		FileReader arq = new FileReader(nomeEntrada);
		BufferedReader lerArq = new BufferedReader(arq);
		
		String texto = lerArq.readLine();
		
		while(texto != null) {
			
			int x =  Integer.parseInt(texto.substring(0, 2).trim());
			int y;
			
			if(texto.length() > 5)
				 y = Integer.parseInt(texto.substring(4, 6).trim());
			else 
				y = Integer.parseInt(texto.substring(4, 5).trim());
			
			Elo elo_x = new Elo();
			elo_x.chave = x;
			
			Elo elo_y = new Elo();
			elo_y.chave = y;
			
			if(buscaElem(x) == false) {
				if(prim == null) {
					this.prim = elo_x;
					this.ult = elo_x;
				} else
					this.ult.prox = elo_x;
					ult = elo_x;
				
				this.n++;
			} else {
				elo_x = retornaElemIgual(elo_x.chave);
			}
			
			if(buscaElem(y) == false) {
				this.ult.prox = elo_y;
				this.ult = elo_y;
				
				this.n++;
			} else {
				elo_y = retornaElemIgual(elo_y.chave);
			}
			
			EloSuc eloSuc = new EloSuc();
			eloSuc.id = elo_y;
			eloSuc.prox = elo_x.listaSuc;
			elo_x.listaSuc = eloSuc;			
			
			elo_y.contador++;	
			
			texto = lerArq.readLine();
		}
		
		lerArq.close();
	}
	
	public boolean buscaElem(int chave) {
		if(prim == null)
			return false;
		
		for(Elo i = this.prim; i != null; i = i.prox) {
			if(i.chave == chave)
				return true;
		}
		
		return false;			
	}
	
	/* M�todo para impress�o do estado atual da estrutura de dados. */
	public void debug()
	{
		for(Elo i = this.prim; i != null; i = i.prox) {
			System.out.print(i.chave);
			System.out.print(" predecessores: " + i.contador + ",");
			System.out.print(" sucessores: ");
			
			if(i.listaSuc != null) {
				EloSuc j = i.listaSuc;
				
				do {
					System.out.print(j.id.chave + " -> ");
					j = j.prox;
					
				} while(j != null);
				
				System.out.print("null");

			} else {
				System.out.print("null");
			}
						
			System.out.println();
		}
	}
	
	/* M�todo respons�vel por executar o algoritmo. */
	public boolean executa()
	{
		/* Preencher. */
		
		return false;
	}
	
	public Elo retornaElemIgual(int chave) {
		for(Elo i = this.prim; i != null; i = i.prox) {
			if(i.chave == chave)
				return i;
		}
		
		return null;
	}
}
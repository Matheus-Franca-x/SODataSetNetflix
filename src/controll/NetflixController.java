package controll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controllerFila.FilaObject;
import matheus.ListaObject.ListaObject;
import model.Serie;

public class NetflixController implements INetflixController
{
	
	ListaObject[] listaRating;
	
	public NetflixController() 
	{
		listaRating = new ListaObject[7];
		iniciaListaRating();
	}
	
	public void iniciaListaRating()
	{
		int tamanho = listaRating.length;
		for (int i = 0; i < tamanho; i++)
		{
			listaRating[i] = new ListaObject();
		}
	}

	@Override
	public void callFila() throws Exception
	{
		fila();
	}

	@Override
	public void callLista() throws Exception
	{
		lista();
	}
	
	public void callListaRating() throws Exception
	{
		rating();
	}
	
	private void fila() throws Exception
	{
		
		File arq = new File("C:\\TEMP", "netflix_originals_series_2.csv");
		
		if (arq.exists() && arq.isFile())
		{
			
			FileInputStream abreFlux = new FileInputStream(arq);
			InputStreamReader lerFlux = new InputStreamReader(abreFlux);
			BufferedReader buffer = new BufferedReader(lerFlux);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			linha = buffer.readLine(); 
			
			FilaObject fila = new FilaObject();
			Serie serie = null;
			
			while (linha != null)
			{
				String[] vet = linha.split(";"); 
				
				serie = new Serie(vet[0], vet[1], vet[2], Integer.parseInt(vet[4]), vet[5], vet[6], Integer.parseInt(vet[11]));
				fila.insert(serie);
				
				linha = buffer.readLine();
			}
			
			
			buffer.close();
			lerFlux.close();
			abreFlux.close();
			
			File dir = new File("C:\\TEMP");
			
			if(!dir.exists()) 
			{
				dir.mkdirs();
			}
			
			boolean existe = false;
			Serie s = null;
			
			
			File arq1 = new File("C:\\TEMP", "major_genrer.csv");
			existe = false;
			if(arq1.exists())
			{
				existe = true;
			}
			
			
			FileWriter abreArq = new FileWriter(arq1, existe);
			PrintWriter escreveArq = new PrintWriter(abreArq);
			String conteudo = "";
			
			
			while(!fila.filaVazia())
			{
				s = (Serie) fila.remove();
				
				conteudo = s.getMajor_genre() + "\n";
				
				
				escreveArq.write(conteudo); 
				escreveArq.flush();
				
			}
			
			escreveArq.close();
			abreArq.close();
			
		}
			
	}
	
	private void lista() throws Exception
	{
		File arq = new File("C:\\TEMP", "netflix_originals_series_2.csv"); 
		
		if (arq.exists() && arq.isFile())
		{
			
			FileInputStream abreFlux = new FileInputStream(arq);
			InputStreamReader lerFlux = new InputStreamReader(abreFlux);
			BufferedReader buffer = new BufferedReader(lerFlux);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			linha = buffer.readLine(); 
			
			ListaObject lista = new ListaObject();
			Serie serie = null;
			
			while (linha != null)
			{
				String[] vet = linha.split(";"); 
				
				serie = new Serie(vet[0], vet[1], vet[2], Integer.parseInt(vet[4]), vet[5], vet[6], Integer.parseInt(vet[11]));
				if (lista.isEmpty())
				{
					lista.addFirst(serie);					
				}
				else
				{
					lista.addLast(serie);
				}
				
				linha = buffer.readLine();
			}
			
			
			buffer.close();
			lerFlux.close();
			abreFlux.close();
			
			File dir = new File("C:\\TEMP");
			
			if(!dir.exists()) 
			{
				dir.mkdirs();
			}
			
			boolean existe = false;
			Serie s = null;
			
			
			File arq1 = new File("C:\\TEMP", "premiere_year.csv");
			existe = false;
			if(arq1.exists())
			{
				existe = true;
			}
			
			FileWriter abreArq = new FileWriter(arq1, existe);
			PrintWriter escreveArq = new PrintWriter(abreArq);
			String conteudo = "";
			
			
			while(!lista.isEmpty())
			{
				s = (Serie) lista.get(0);
				lista.removeFirst();
				
				if(s.getStatus().equals("Renewed"))
				{
					conteudo = s.getPremiere_year() + "\n";
				
					escreveArq.write(conteudo); 
					escreveArq.flush();
				}
				
			}
			
			escreveArq.close();
			abreArq.close();
			
		}
	}
	
	private void rating() throws Exception
	{
		File arq = new File("C:\\TEMP", "netflix_originals_series_2.csv"); 
		
		if (arq.exists() && arq.isFile())
		{
			
			FileInputStream abreFlux = new FileInputStream(arq);
			InputStreamReader lerFlux = new InputStreamReader(abreFlux);
			BufferedReader buffer = new BufferedReader(lerFlux);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			linha = buffer.readLine(); 
			
			ListaObject lista = new ListaObject();
			Serie serie = null;
			
			while (linha != null)
			{
				String[] vet = linha.split(";"); 
				
				serie = new Serie(vet[0], vet[1], vet[2], Integer.parseInt(vet[4]), vet[5], vet[6], Integer.parseInt(vet[11]));
				
				int hash = serie.hashCode();
				
				if (lista.isEmpty())
				{
					listaRating[hash].addFirst(serie);					
				}
				else
				{
					listaRating[hash].addLast(serie);
				}
				
				linha = buffer.readLine();
			}
			
			
			buffer.close();
			lerFlux.close();
			abreFlux.close();
		}
	}
}

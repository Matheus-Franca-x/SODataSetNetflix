package view;

import controll.NetflixController;

public class Main {

	public static void main(String[] args)  throws Exception
	{
		
		NetflixController controll = new NetflixController();
		
		controll.callFila();
		controll.callLista();
		controll.callListaRating();
		controll.consultaRating(5);
	}

}

package grafo;

public class GrafoMain {
	public static void main(String[] args) {
		Grafo<String> grafo_nomes = new Grafo<String>();
		grafo_nomes.addObjeto("1");
		grafo_nomes.addObjeto("2");
		grafo_nomes.addObjeto("3");
		grafo_nomes.addObjeto("4");
		grafo_nomes.addObjeto("5");
		grafo_nomes.addObjeto("6");
		grafo_nomes.addObjeto("7");
		grafo_nomes.addObjeto("8");
		grafo_nomes.addObjeto("9");
		grafo_nomes.addObjeto("10");
		grafo_nomes.conectar(0, 1, 10);
		grafo_nomes.conectar(0, 3, 20);
		grafo_nomes.conectar(0, 4, 20);
		grafo_nomes.conectar(0, 5, 5);
		grafo_nomes.conectar(0, 6, 15);
		grafo_nomes.conectar(0, 7, 5);
		grafo_nomes.conectar(5, 6, 10);
		grafo_nomes.conectar(4, 5, 5);
		grafo_nomes.conectar(3, 4, 10);
		grafo_nomes.conectar(2, 3, 5);
		grafo_nomes.conectar(1, 2, 5);
		grafo_nomes.conectar(1, 9, 5);
		grafo_nomes.conectar(2, 9, 15);
		grafo_nomes.conectar(8, 9, 10);
		grafo_nomes.conectar(1, 8, 15);
		grafo_nomes.conectar(7, 8, 20);
		grafo_nomes.conectar(1, 7, 20);
		grafo_nomes.conectar(1, 3, 10);
		grafo_nomes.findPath(5, 9);
	}
}

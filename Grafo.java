package grafo;

import java.util.ArrayList;

public class Grafo<T> {

	private ArrayList<T> objetos;
	private ArrayList<Connection> conexoes;
	
	public Grafo() {
		this.objetos = new ArrayList<T>();
		this.conexoes = new ArrayList<Connection>();
	}
	
	public void addObjeto(T objeto) {
		objetos.add(objeto);
	}
	
	public T getObjeto(int index) {
		return objetos.get(index);
	}
	
	public void conectar(int index_obj1, int index_obj2, int coust) {
		conexoes.add(new Connection(index_obj1, index_obj2, coust));
		conexoes.add(new Connection(index_obj2, index_obj1, coust));
		//bidirectional
	}
	
	public boolean findPath(int index_obj1, int index_obj2) {
		Path path = path(index_obj1,index_obj2);
		if(path != null) {
			for(Connection c: path.path)
				System.out.println(getObjeto(c.objects_index[0])+" is connected to "+getObjeto(c.objects_index[1]));
			System.out.println("Total coust: "+path.total_coust);
			return true;
		}
		System.out.println("There's no path that connect the points");
		return false;
	}

	private Path path(int index_obj1, int index_obj2) {
		ArrayList<Path> paths = new ArrayList<Path>();
		ArrayList<Integer> explorateds = new ArrayList<Integer>();
		Path minor_path = new Path(new ArrayList<Connection>(), 0);
		
		for(Connection conn: getConnections(index_obj1)) {
			Path new_path = new Path(minor_path.path, minor_path.total_coust);
			new_path.add(conn);
			paths.add(new_path);
		}
		
		while(!paths.isEmpty()) {
			minor_path = paths.get(paths.size()-1);
			for(Path path: paths)
				if(path.total_coust < minor_path.total_coust) minor_path = path;
			
			if(minor_path.getLast().objects_index[1] == index_obj2) return minor_path;
			
			paths.remove(minor_path);
			explorateds.add(minor_path.getLast().objects_index[0]);
			for(Connection conn: getConnections(minor_path.getLast().objects_index[1])){
				if(explorateds.contains(conn.objects_index[1])) continue;
				Path new_path = new Path(minor_path.path, minor_path.total_coust);
				new_path.add(conn);
				paths.add(new_path);
			}
		}
		
		return null;//there's no path
	}
	
	private ArrayList<Connection> getConnections(int node){
		ArrayList<Connection> connections = new ArrayList<Connection>();
		for(Connection conn: conexoes) {
			if(conn.objects_index[0] == node)
			connections.add(conn);
		}
		return connections;
	}
	
	private class Path {
		private ArrayList<Connection> path = new ArrayList<Connection>();
		private int total_coust;
		
		public Path(ArrayList<Connection> path, int total_coust) {
			this.path.addAll(path);
			this.total_coust = total_coust;
		}
		
		public void add(Connection new_conn) {
			path.add(new_conn);
			total_coust += new_conn.coust;
		}
		
		public Connection getLast() {
			return path.get(path.size()-1);
		}
	}
	
	private class Connection {
		private int objects_index[] = new int[2];
		private int coust;
		public Connection(int index_obj1, int index_obj2, int coust) {
			this.objects_index[0] = index_obj1;
			this.objects_index[1] = index_obj2;
			this.coust = coust; 
		}
	}
}

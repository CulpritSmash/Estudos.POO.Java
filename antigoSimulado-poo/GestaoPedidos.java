//Questão 4

import java.util.ArrayList;

public class GestaoPedidos{
	ArrayList<String> pedidos;

	public GestaoPedidos(){
		pedidos = new ArrayList<>();
	}

	public void adicionarPedido(String item){
		pedidos.add(item);
	}

	public String proximoPedido(){
		if(pedidos.get(0) != null){
			String temp = pedidos.get(0);
			pedidos.remove(0);
			return temp;
		}
		return "Fila Vazia";
	}

	public int quantidadePendentes(){
		return pedidos.size();
	}

	public void listarPedidos(){
		for(int i = 0; i < quantidadePendentes(); i++){
			System.out.println(pedidos.get(i));
		}
	}

	public static void main(String[] args){
		GestaoPedidos pedidos = new GestaoPedidos();

		

		pedidos.adicionarPedido("Banana");
		pedidos.adicionarPedido("Maçã");
		pedidos.adicionarPedido("Laranja");

		pedidos.proximoPedido();

		pedidos.listarPedidos();
	}
}

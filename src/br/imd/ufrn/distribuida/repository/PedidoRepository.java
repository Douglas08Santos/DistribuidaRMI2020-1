package br.imd.ufrn.distribuida.repository;

import java.util.List;

import br.imd.ufrn.distribuida.model.Cliente;
import br.imd.ufrn.distribuida.model.pedidos.Pedido;

public interface PedidoRepository {
	public void add(Pedido pedido);
    public void remove(Pedido pedido);
    public List<Pedido> listAll(Cliente cliente);
}

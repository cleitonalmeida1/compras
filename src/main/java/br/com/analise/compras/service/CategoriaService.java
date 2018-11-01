package br.com.analise.compras.service;

import br.com.analise.compras.Entity.Categoria;
import br.com.analise.compras.Entity.Produto;
import br.com.analise.compras.exception.ObjectNotFountException;
import br.com.analise.compras.exception.ObjectPossuiDependenciaException;
import br.com.analise.compras.repository.CategoriaRepository;
import br.com.analise.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Categoria buscarCategoriaPorId(Integer id) {

        Categoria categoria = categoriaRepository.findOne(id);

        if (categoria == null) {
            throw new ObjectNotFountException("O objeto " + Categoria.class.getName() +
                    " com ID: " + id + " não foi encontrado!");
        }

        return categoria;
    }

    public Categoria salvar(Categoria categoria) {
        Categoria catSalva = categoriaRepository.save(categoria);

        /*List<Produto> produtos = categoria.getProdutos();

        produtos.forEach(produto -> produto.getCategorias().add(catSalva));

        produtoRepository.save(categoria.getProdutos());*/
        return catSalva;
    }

    public void deletar(Categoria categoria) {

        List<Produto> produtos = categoria.getProdutos();

        if (!produtos.isEmpty()) {
            throw new ObjectPossuiDependenciaException("Não pode ser excluído porque possui produtos associados!");
        } else {
            categoriaRepository.delete(categoria);
        }
    }

    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }
}

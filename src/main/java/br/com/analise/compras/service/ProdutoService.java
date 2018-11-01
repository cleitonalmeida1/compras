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
import java.util.Objects;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscarProdutoPorId(Integer id) {

        Produto produto = produtoRepository.findOne(id);

        if (produto == null) {
            throw new ObjectNotFountException("O objeto " + Produto.class.getName() +
                    " com ID: " + id + " não foi encontrado!");
        }

        return produto;
    }

    public Produto salvar(Produto produto) {

        Produto produtoExistente = produtoRepository.buscarPorNome(produto.getNome());

        if (Objects.nonNull(produtoExistente)) {
            throw new ObjectNotFountException("O produto já existe!");
        }

        Produto produtoSalvo = produtoRepository.save(produto);

        return produtoSalvo;
    }

    public void deletar(Produto produto) {
        produtoRepository.delete(produto);
    }

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }
}

package br.com.analise.compras.resource;


import br.com.analise.compras.Entity.Categoria;
import br.com.analise.compras.Entity.Produto;
import br.com.analise.compras.service.CategoriaService;
import br.com.analise.compras.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/produtos")
@CrossOrigin("http://localhost:8081")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> salvarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok().body(produtoService.salvar(produto));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> buscarProdutos() {
        return ResponseEntity.ok().body(produtoService.buscarTodos());
    }
}

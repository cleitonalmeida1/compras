package br.com.analise.compras.resource;


import br.com.analise.compras.Entity.Categoria;
import br.com.analise.compras.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/categorias")
@CrossOrigin("http://localhost:8081")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> buscarCategoria(@PathVariable("id") Integer id) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);
        return ResponseEntity.ok().body(categoria);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> salvarCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok().body(categoriaService.salvar(categoria));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> buscarCategorias() {
        return ResponseEntity.ok().body(categoriaService.buscarTodas());
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void excluirCategoria(@RequestBody Categoria categoria) {
        categoriaService.deletar(categoria);
    }
}

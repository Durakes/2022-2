using Microsoft.AspNetCore.Mvc;
using WebAPI.Services;
using WebAPI.Model;

namespace WebAPI.Controllers
{
    [Route("Api/[Controller]")]
    [ApiController]
    public class ProductoController : Controller
    {
        private ProductRepository repo = new ProductRepository();

        [HttpGet]
        public IActionResult Get()
        {
            return Ok(repo.ObtenerTodosLosProductos());
        }
        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var objActual = repo.ObtenerProductoPorId(id);
            if(objActual == null)
            {
                var error = NotFound("El producto " + id.ToString() + " no existe.");
                return error;
            }
            return Ok(objActual);
        }
        [HttpPost("agregar")]
        public IActionResult addProducto(Producto producto)
        {
            repo.add(producto);
            return CreatedAtAction(nameof(addProducto), producto);
        }
        [HttpDelete("eliminar/id")]
        public IActionResult eliminarProducto(int id)
        {
            repo.eliminar(id);
            return Ok();
        }
        [HttpPut("modificar")]
        public IActionResult modificarProducto(Producto producto)
        {
            repo.modificar(producto);
            return CreatedAtAction(nameof(modificarProducto), producto);
        }
    }
}

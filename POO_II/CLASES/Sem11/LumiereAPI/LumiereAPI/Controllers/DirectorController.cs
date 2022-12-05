using Microsoft.AspNetCore.Mvc;
using LumiereAPI.Models;
using LumiereAPI.Services;

namespace LumiereAPI.Controllers
{
    [Route("Api/[Controller]")]
    [ApiController]
    public class DirectorController : Controller
    {
        private bdlumiereContext Context;
        DirectorRepository dir = new DirectorRepository();
        public DirectorController(bdlumiereContext context)
        {
            Context = context;
        }
        [HttpGet]
        public IActionResult Get()
        {
            var lstDirector = (from dir in Context.Directors select dir).ToList();

            return Ok(lstDirector);
        }
        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var obj = (from dir in Context.Directors select dir).Where(prop => prop.IdDirector == id).FirstOrDefault();

            if (obj == null)
            {
                var error = NotFound("El producto" + id.ToString() + " no existe");
                return error;
            }

            return Ok(obj);

        }
        [Route("agregar")]
        public IActionResult addDirector(Director director)
        {
            if (ModelState.IsValid)
            {
                Context.Directors.Add(director);
                Context.SaveChanges();

            }
            
            //pro.add(director);
            return CreatedAtAction(nameof(addDirector), director);
        }
        [HttpPut("modificar")]
        public IActionResult modificarDirector(Director director)
        {
            //pro.modificar(director);
            if (ModelState.IsValid)
            {
                var ObjOld = (from dir in Context.Directors
                              where dir.IdDirTmdb == director.IdDirTmdb
                              select dir).Single();

                ObjOld.IdDirTmdb = director.IdDirTmdb;
                ObjOld.NomDirector = director.NomDirector;
                ObjOld.BioDirector = director.BioDirector;
                ObjOld.UrlFoto = director.UrlFoto;

                Context.SaveChanges();
            }
            return CreatedAtAction(nameof(modificarDirector), director);
        }
        [HttpDelete("eliminar/{id}")]
        public IActionResult eliminarProducto(int id)
        {
            //pro.eliminar(id);
            var Obj = (from dir in Context.Directors
                       where dir.IdDirector == id
                       select dir).Single();
            Context.Directors.Remove(Obj);
            Context.SaveChanges();
            return NoContent();
        }
    }
}

using LumiereAPI.Models;
using LumiereAPI.Controllers;
using Microsoft.AspNetCore.Mvc;

namespace LumiereAPI.Services
{
    public class DirectorRepository
    {
        private readonly bdlumiereContext Context;
        /*public DirectorRepository(bdlumiereContext context)
        {
            Context = context;
        }*/

        public List<Director> lstDirector = new List<Director>();
        public IEnumerable<Director> ObtenerTodosLosProductos()
        {
            lstDirector = (from dir in Context.Directors select dir).OrderByDescending((x => x.IdDirector)).ToList();
            return lstDirector;
        }

        public Director ObtenerProductoPorID(int id)
        {
            var obj = (from dir in Context.Directors select dir).Where(prop => prop.IdDirector == id).FirstOrDefault();

            return obj;
        }

        public void addDirector(Director objDirector)
        {
            Context.Directors.Add(objDirector);
            Context.SaveChanges();
            lstDirector.Add(objDirector);
        }
        public void modificar(Director nuevoDir)
        {
            var originalDir = lstDirector.Where(prop => prop.IdDirector == nuevoDir.IdDirector).FirstOrDefault();

            originalDir.IdDirector= nuevoDir.IdDirector;
            originalDir.IdDirTmdb= nuevoDir.IdDirTmdb;
            originalDir.NomDirector = nuevoDir.NomDirector;
            originalDir.BioDirector = nuevoDir.BioDirector;
            originalDir.UrlFoto = nuevoDir.UrlFoto;

            Context.SaveChanges();

        }

        public void eliminar(int id)
        {
            var Obj = (from Talu in Context.Directors
                       where Talu.IdDirector == id
                       select Talu).Single();
            Context.Directors.Remove(Obj);
            Context.SaveChanges();
            lstDirector.Remove(Obj);

        }
    }
}

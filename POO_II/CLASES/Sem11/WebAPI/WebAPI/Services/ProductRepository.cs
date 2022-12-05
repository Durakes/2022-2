using System.Threading;
using WebAPI.Model;
namespace WebAPI.Services
{
    public class ProductRepository
    {
        public static List<Producto> lstProducto = new List<Producto>()
        {
            new Producto() {Id = 1, Descripcion = "Lacteos", Monto = 20.00},
            new Producto() {Id = 2, Descripcion = "Arroz", Monto = 2.00},
            new Producto() {Id = 3, Descripcion = "Leche", Monto = 4.00},
            new Producto() {Id = 4, Descripcion = "Carne", Monto = 20.00}
        };

        public IEnumerable<Producto> ObtenerTodosLosProductos()
        {
            return lstProducto;
        }

        public Producto ObtenerProductoPorId(int id)
        {
            return lstProducto.Where(p => p.Id == id).FirstOrDefault();
        }

        public void add(Producto obj)
        {
            lstProducto.Add(obj);
        }

        public void eliminar(int id)
        {
            var obj = lstProducto.Where(prop => prop.Id == id).FirstOrDefault();
            lstProducto.Remove(obj);
        }

        public void modificar(Producto objConDatosModificados)
        {
            var obj = lstProducto.Where(prop => prop.Id == objConDatosModificados.Id).FirstOrDefault();
            obj.Descripcion = objConDatosModificados.Descripcion;
            obj.Monto = objConDatosModificados.Monto;
        }

    }
}

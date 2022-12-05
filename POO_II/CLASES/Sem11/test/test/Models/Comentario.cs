using System;
using System.Collections.Generic;

namespace test.Models
{
    public partial class Comentario
    {
        public int IdComentario { get; set; }
        public int IdUsuario { get; set; }
        public int IdPelicula { get; set; }
        public string? Texto { get; set; }
        public string? FechaPublicacion { get; set; }
        public bool? Estado { get; set; }
    }
}

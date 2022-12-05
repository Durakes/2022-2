using System;
using System.Collections.Generic;

namespace test.Models
{
    public partial class Usuario
    {
        public int IdUsuario { get; set; }
        public string? NomUsuario { get; set; }
        public string? ApeUsuario { get; set; }
        public string? Username { get; set; }
        public string? Contraseña { get; set; }
        public string? FechaNacimiento { get; set; }
        public string? Descripcion { get; set; }
        public string? FechaCreacion { get; set; }
        public string? UrlFoto { get; set; }
    }
}

using System;
using System.Collections.Generic;

namespace ClaseMartes.Models
{
    public partial class Alumno
    {
        public string IdAlumno { get; set; } = null!;
        public string? AluPaterno { get; set; }
        public string? AluMaterno { get; set; }
        public string? AluNombres { get; set; }
        public string? AluSexo { get; set; }
        public string? AluCodigo { get; set; }
        public string? IdEstadocivil { get; set; }
        public string? AluEmail { get; set; }
    }
}

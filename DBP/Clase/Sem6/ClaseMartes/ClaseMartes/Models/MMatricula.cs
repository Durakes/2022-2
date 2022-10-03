using System;
using System.Collections.Generic;

namespace ClaseMartes.Models
{
    public partial class MMatricula
    {
        public string IdMatricula { get; set; } = null!;
        public string? MatFecha { get; set; }
        public string? MatResponsable { get; set; }
        public string IdAlumno { get; set; } = null!;
        public string? IdCondicion { get; set; }
        public string? IdNivelmodalidad { get; set; }
        public string? IdGrado { get; set; }
        public string? IdSeccion { get; set; }
        public string? IdAnio { get; set; }
        public string? IdSituacion { get; set; }
        public string? IdTurno { get; set; }
        public string? MatEstado { get; set; }
    }
}

using System;
using System.Collections.Generic;

namespace LumiereAPI.Models
{
    public partial class Director
    {
        public int IdDirector { get; set; }
        public int? IdDirTmdb { get; set; }
        public string? NomDirector { get; set; }
        public string? BioDirector { get; set; }
        public string? UrlFoto { get; set; }
    }
}

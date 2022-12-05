using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace LumiereAPI.Models
{
    public partial class bdlumiereContext : DbContext
    {
        public bdlumiereContext()
        {
        }

        public bdlumiereContext(DbContextOptions<bdlumiereContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Director> Directors { get; set; } = null!;

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.UseCollation("utf8mb4_general_ci")
                .HasCharSet("utf8mb4");

            modelBuilder.Entity<Director>(entity =>
            {
                entity.HasKey(e => e.IdDirector)
                    .HasName("PRIMARY");

                entity.ToTable("director");

                entity.HasCharSet("utf8")
                    .UseCollation("utf8_general_ci");

                entity.Property(e => e.IdDirector)
                    .HasColumnType("int(11)")
                    .HasColumnName("id_director");

                entity.Property(e => e.BioDirector)
                    .HasMaxLength(2500)
                    .HasColumnName("bio_director");

                entity.Property(e => e.IdDirTmdb)
                    .HasColumnType("int(11)")
                    .HasColumnName("id_dir_tmdb");

                entity.Property(e => e.NomDirector)
                    .HasMaxLength(50)
                    .HasColumnName("nom_director");

                entity.Property(e => e.UrlFoto)
                    .HasMaxLength(100)
                    .HasColumnName("url_foto");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}

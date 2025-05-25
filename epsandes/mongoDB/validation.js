db.runCommand({
  collMod: "ips",
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["nombre", "tipo", "direccion", "telefono", "serviciosOfrecidos", "medicosContratados"],
      properties: {
        nombre: { bsonType: "string" },
        tipo: { bsonType: "string" },
        direccion: { bsonType: "string" },
        telefono: { bsonType: "string" },
        serviciosOfrecidos: {
          bsonType: "array",
          items: { bsonType: "string" }
        },
        medicosContratados: {
          bsonType: "array",
          items: { bsonType: "string" }
        }
      }
    }
  }
});

db.runCommand({
  collMod: "afiliados",
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["tipoDocumento", "numeroDocumento", "nombre", "fechaNacimiento", "direccion", "telefono", "tipo"],
      properties: {
        tipoDocumento: { bsonType: "string" },
        numeroDocumento: { bsonType: "string" },
        nombre: { bsonType: "string" },
        fechaNacimiento: { bsonType: "string" }, // o "date" si usas objetos Date en Mongo
        direccion: { bsonType: "string" },
        telefono: { bsonType: "string" },
        tipo: { enum: ["contribuyente", "beneficiario"] },
        parentesco: { bsonType: "string" },         // opcional
        idContribuyente: { bsonType: "string" }     // opcional
      }
    }
  }
});

db.runCommand({
  collMod: "medicos",
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["nombre", "tipoDocumento", "numeroDocumento", "especialidad", "numeroRegistroMedico", "ipsAfiliadas"],
      properties: {
        nombre: { bsonType: "string" },
        tipoDocumento: { bsonType: "string" },
        numeroDocumento: { bsonType: "string" },
        especialidad: { bsonType: "string" },
        numeroRegistroMedico: { bsonType: "string" },
        ipsAfiliadas: {
          bsonType: "array",
          items: { bsonType: "string" }
        }
      }
    }
  }
});

db.runCommand({
  collMod: "ordenes",
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["fecha", "idPaciente", "idServicio", "idMedico", "estado"],
      properties: {
        fecha: { bsonType: "string" }, // o "date" si usas LocalDate como fecha ISO
        idPaciente: { bsonType: "string" },
        idServicio: { bsonType: "string" },
        idMedico: { bsonType: "string" },
        estado: { enum: ["vigente", "cancelada", "completada"] }
      }
    }
  }
});

db.runCommand({
  collMod: "citas",
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["fecha", "hora", "servicioId", "afiliadoId", "ipsId", "medicoId"],
      properties: {
        fecha: { bsonType: "string" },
        hora: { bsonType: "string" },
        servicioId: { bsonType: "string" },
        afiliadoId: { bsonType: "string" },
        ipsId: { bsonType: "string" },
        medicoId: { bsonType: "string" },
        ordenId: { bsonType: "string" }
      }
    }
  }
});

db.runCommand({
  collMod: "servicios",
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["nombre", "descripcion", "tipo", "costo"],
      properties: {
        nombre: { bsonType: "string" },
        descripcion: { bsonType: "string" },
        tipo: { bsonType: "string" },
        costo: { bsonType: "int" } 
      }
    }
  }
});



//poblar ips
db.ips.insertOne({
  nombre: "Clínica Los Andes",
  tipo: "Hospital",
  direccion: "Calle 123 #45-67",
  telefono: "6011234567",
  serviciosOfrecidos: ["consulta_general", "examenes", "urgencias"],
  medicosContratados: ["med1", "med2", "med3"]
}).insertedId;

db.ips.insertOne({
  nombre: "Laboratorio Salud Total",
  tipo: "Laboratorio",
  direccion: "Avenida 5 #10-20",
  telefono: "6017654321",
  serviciosOfrecidos: ["examenes", "terapias"],
  medicosContratados: ["med4", "med5"]
}).insertedId;

//poblar servicios
db.servicios.insertOne({
  nombre: "Consulta Médico General",
  descripcion: "Consulta inicial sin orden previa",
  tipo: "consulta_general",
  costo: 50000
}).insertedId;

db.servicios.insertOne({
  nombre: "Examen de Sangre",
  descripcion: "Hemograma completo",
  tipo: "examenes",
  costo: 30000
}).insertedId;

db.servicios.insertOne({
  nombre: "Consulta de Urgencias",
  descripcion: "Atención prioritaria por emergencia",
  tipo: "urgencias",
  costo: 100000
}).insertedId;

//poblar medicos
db.medicos.insertMany([
  {
    nombre: "Dra. María Torres",
    tipoDocumento: "CC",
    numeroDocumento: "med1",
    especialidad: "Medicina General",
    numeroRegistroMedico: "RM001",
    ipsAfiliadas: ["Clínica Los Andes"]
  },
  {
    nombre: "Dr. Andrés Ramírez",
    tipoDocumento: "CC",
    numeroDocumento: "med2",
    especialidad: "Pediatría",
    numeroRegistroMedico: "RM002",
    ipsAfiliadas: ["Clínica Los Andes"]
  },
  {
    nombre: "Dra. Camila Salazar",
    tipoDocumento: "CC",
    numeroDocumento: "med3",
    especialidad: "Urgencias",
    numeroRegistroMedico: "RM003",
    ipsAfiliadas: ["Clínica Los Andes"]
  },
  {
    nombre: "Dr. Felipe Méndez",
    tipoDocumento: "CE",
    numeroDocumento: "med4",
    especialidad: "Laboratorio Clínico",
    numeroRegistroMedico: "RM004",
    ipsAfiliadas: ["Laboratorio Salud Total"]
  },
  {
    nombre: "Dra. Laura Gutiérrez",
    tipoDocumento: "CE",
    numeroDocumento: "med5",
    especialidad: "Terapia Física",
    numeroRegistroMedico: "RM005",
    ipsAfiliadas: ["Laboratorio Salud Total"]
  }
]);

//poblar afiliados
// Insertar contribuyentes
var contrib1 = db.afiliados.insertOne({
  tipoDocumento: "CC",
  numeroDocumento: "1001001001",
  nombre: "Carlos Rodríguez",
  fechaNacimiento: "1985-04-15",
  direccion: "Carrera 45 #12-34",
  telefono: "3104567890",
  tipo: "contribuyente"
}).insertedId;

var contrib2 = db.afiliados.insertOne({
  tipoDocumento: "CC",
  numeroDocumento: "2002002002",
  nombre: "Lucía Martínez",
  fechaNacimiento: "1990-06-22",
  direccion: "Calle 78 #45-12",
  telefono: "3209876543",
  tipo: "contribuyente"
}).insertedId;

// Insertar beneficiarios (referenciando los contribuyentes)
db.afiliados.insertMany([
  {
    tipoDocumento: "TI",
    numeroDocumento: "3003003003",
    nombre: "Juan Rodríguez",
    fechaNacimiento: "2010-09-10",
    direccion: "Carrera 45 #12-34",
    telefono: "3104567890",
    tipo: "beneficiario",
    parentesco: "hijo",
    idContribuyente: contrib1.valueOf()
  },
  {
    tipoDocumento: "TI",
    numeroDocumento: "4004004004",
    nombre: "Sofía Gómez",
    fechaNacimiento: "2012-11-25",
    direccion: "Calle 78 #45-12",
    telefono: "3209876543",
    tipo: "beneficiario",
    parentesco: "hija",
    idContribuyente: contrib2.valueOf()
  }
]);

//poblar ordenes
db.ordenes.insertMany([
  {
    fecha: "2024-05-10",
    idPaciente: "1001001001", // númeroDocumento del afiliado Carlos Rodríguez
    idServicio: "Consulta General", // nombre del servicio
    idMedico: "med1", // númeroDocumento del médico María Torres
    estado: "vigente"
  },
  {
    fecha: "2024-05-12",
    idPaciente: "3003003003", // númeroDocumento del beneficiario Juan Rodríguez
    idServicio: "Examen de Laboratorio",
    idMedico: "med4",
    estado: "completada"
  },
  {
    fecha: "2024-05-14",
    idPaciente: "2002002002", // Lucía Martínez
    idServicio: "Vacunación",
    idMedico: "med2",
    estado: "cancelada"
  }
]);

// Citas para RFC1 (próximas 4 semanas)
db.Cita.insertMany([
  {
    fecha: "2024-06-03",
    hora: "14:00",
    servicioId: "urgencias",
    ipsId: "Clínica Los Andes",
    medicoId: "med3",
    estado: "disponible"
  },
  {
    fecha: "2024-06-04",
    hora: "11:15",
    servicioId: "terapias",
    ipsId: "Laboratorio Salud Total",
    medicoId: "med5",
    estado: "disponible"
  }
]);
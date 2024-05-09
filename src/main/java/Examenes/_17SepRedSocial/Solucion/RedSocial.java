package Examenes._17SepRedSocial.Solucion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class RedSocial {
    private SortedMap<String, Cuenta> cuentas;
    private String usuario_activo;

    public RedSocial(){
        this.cuentas = new TreeMap<>();
        this.usuario_activo = null;
        crearCuenta("ADMIN");
    }
    public void login(String usr){
        if(!this.cuentas.containsKey(usr.toUpperCase()))
            throw new AppException("La cuenta no existe");

        this.usuario_activo = usr.toUpperCase();
    }

    public void logout(){
        this.usuario_activo = null;
    }

    public void crearCuenta(String usr){
        if((this.usuario_activo != null && !this.usuario_activo.equalsIgnoreCase("admin")) && this.cuentas.containsKey(usr.toUpperCase()))
            throw new AppException("La cuenta ya existe");

        this.cuentas.put(usr.toUpperCase(), new Cuenta(usr));
    }

    public void addMsj(String receptor, String txt){
        if(usuario_activo == null)
            throw new AppException("No hay un usuario logeado");

        this.cuentas.get(this.usuario_activo).addMsj(receptor, txt);
    }

    public SortedSet<Mensaje> getMsjsCon(String usuario){
        if(!this.cuentas.containsKey(usuario.toUpperCase()))
            throw new AppException("No existe la cuenta de usuario: " + usuario);

        return this.cuentas.get(this.usuario_activo).getMsjs(new FiltroReceptor(usuario));
    }

    public SortedSet<Mensaje> getMsjsClaves(Set<String> c){
        return this.cuentas.get(this.usuario_activo).getMsjs(new FiltroTexto(c));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for(Map.Entry<String, Cuenta> entry : this.cuentas.entrySet()){
            sb.append(entry.getKey() + ":\n");
            sb.append("\t" + entry.getValue().toString() + "\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public void crearCuentaModerada(String usr, Set<String> c){
        if((this.usuario_activo != null && !this.usuario_activo.equalsIgnoreCase("admin")) && this.cuentas.containsKey(usr))
            throw new AppException("Ya existe la cuenta");

        this.cuentas.put(usr.toUpperCase(), new CuentaModerada(usr, c));
    }

    public void cargarDeFichero(String n) throws IOException {
        String usr_activo = this.usuario_activo;
        try(Scanner sc = new Scanner(Path.of(n))) {
            while(sc.hasNextLine()){
                procesar(sc.nextLine());
            }
        }catch (IOException e){
            throw new IOException();
        }catch (Exception e){
            throw new AppException(e.getMessage());
        }finally {
            // Dejo el usuario que estaba activado despues de procesar todos los ficheros, ya que voy cambiando el usuario
            // logeado segun voy procesando los mensajes
            this.usuario_activo = usr_activo;
        }
    }
    private void procesar(String linea){
        String emisor, receptor, txt;
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter(" *[;] *");
            emisor = sc.next();
            receptor = sc.next();
            txt = sc.next();

            if(!this.cuentas.containsKey(emisor.toUpperCase())){
                // No tenia cuenta todavia creada
                crearCuenta(emisor);
            }
            this.usuario_activo = emisor.toUpperCase();
            addMsj(receptor, txt);

        }catch (Exception e){
            e.printStackTrace();
            throw new AppException("Error al procesar la linea: " + linea + "\n" +
                    "Motivo: " + e.getMessage());
        }
    }

    public void guardarEnFichero(String n) throws IOException {
        try(PrintWriter pw = new PrintWriter(n)){
            for(Cuenta c : this.cuentas.values()){
                for(Mensaje m : c.getMsjs(null)){
                    pw.printf("%s ; %s ; %s\n", m.getEmisor(), m.getReceptor(), m.getTexto());
                }
            }
        }catch (FileNotFoundException ex){
            throw new IOException();
        }catch (Exception ex){
            throw new AppException(ex.getMessage());
        }
    }
}

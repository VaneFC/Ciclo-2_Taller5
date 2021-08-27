package interfaces;

import java.util.List;

public interface Operaciones <T> {
    
    public boolean agregar(T objeto);
    
    public List<T> consultar();
    
    public boolean actualizar(T objeto);
    
    public T buscar(Integer llavePK);
    
}

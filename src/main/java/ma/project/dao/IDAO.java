package ma.project.dao;

public interface IDAO<T> {
	public T Save(T t);
	public void Modify(T t);
	public void Delete(int id);
	public T findById(int id);
	

}

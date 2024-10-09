
public abstract class Animal {
	public abstract void comsulta();
}

class Cachorro extends Animal{
	
	@Override
	public void comsulta() {
		System.out.println("comsulta dog");
	}
}

class Gato extends Animal{

	@Override
	public void comsulta() {
		System.out.println("comsulta cat");
	}
}


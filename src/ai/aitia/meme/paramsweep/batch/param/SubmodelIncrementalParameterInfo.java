package ai.aitia.meme.paramsweep.batch.param;

public class SubmodelIncrementalParameterInfo<T extends Number> extends IncrementalParameterInfo<T> implements ISubmodelParameterInfo {
	
	//====================================================================================================
	// members
	
	private static final long serialVersionUID = -264054169911149696L;
	
	protected SubmodelInfo<?> parent;
	
	//====================================================================================================
	// methods

	//----------------------------------------------------------------------------------------------------
	public SubmodelIncrementalParameterInfo(String name, String description, T defaultValue, final SubmodelInfo<?> parent) {
		super(name,description,defaultValue);
		this.parent = parent;
	}
	
	//----------------------------------------------------------------------------------------------------
	public SubmodelIncrementalParameterInfo(IncrementalParameterInfo<T> p, final SubmodelInfo<?> parent) {
		super(p);
		this.parent = parent;
	}

	//----------------------------------------------------------------------------------------------------
	public SubmodelInfo<?> getParentInfo() { return parent; }
	
	//----------------------------------------------------------------------------------------------------
	@Override
	public SubmodelIncrementalParameterInfo<T> clone() {
		final SubmodelIncrementalParameterInfo<T> clone = new SubmodelIncrementalParameterInfo<T>(this.name,this.description,this.defaultValue,this.parent);
		
		return clone;
	}
}
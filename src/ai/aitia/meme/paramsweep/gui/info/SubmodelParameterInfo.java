package ai.aitia.meme.paramsweep.gui.info;

public class SubmodelParameterInfo extends ParameterInfo implements ISubmodelGUIInfo {

	//====================================================================================================
	// members
	
	private static final long serialVersionUID = 6991443589897247037L;
	
	protected SubmodelInfo parent;
	protected Class<?> parentValue;

	//====================================================================================================
	// methods
	
	//----------------------------------------------------------------------------------------------------
	public SubmodelParameterInfo(final String name, final String type, final Class<?> javaType, final SubmodelInfo parent) {
		this(name,null,type,javaType,parent);
	}
	
	//----------------------------------------------------------------------------------------------------
	public SubmodelParameterInfo(final String name, final String description, final String type, final Class<?> javaType, final SubmodelInfo parent) {
		super(name,description,type,javaType);
		this.parent = parent;
	}

	//----------------------------------------------------------------------------------------------------
	public SubmodelInfo getParent() { return parent; }
	public void setParent(final SubmodelInfo parent) { this.parent = parent; }
	
	//----------------------------------------------------------------------------------------------------
	public Class<?> getParentValue() { return parentValue; }
	public void setParentValue(final Class<?> parentValue) { this.parentValue = parentValue; }

	//----------------------------------------------------------------------------------------------------
	@Override
	public SubmodelParameterInfo clone() {
		final SubmodelParameterInfo clone = new SubmodelParameterInfo(this.name,this.description,this.type,this.javaType,this.parent);
		
		return clone;
	}
	
	//----------------------------------------------------------------------------------------------------
	@Override public boolean isSubmodelParameter() { return true; }
	
	//----------------------------------------------------------------------------------------------------
	@Override
	public boolean equals(final Object o) {
		if (o instanceof SubmodelParameterInfo) {
			final SubmodelParameterInfo that = (SubmodelParameterInfo) o;
			
			if (this.parent == null)
				return that.parent == null && this.name.equals(that.name);
			
			return this.name.equals(that.name) && this.parent.equals(that.parent);
		}
		
		return false;
	}
	
	//----------------------------------------------------------------------------------------------------
	@Override
	public int hashCode() {
		int result = 17;
		if (parent != null)
			result = 31 * result + name.hashCode();
		
		result = 31 * result + parent.hashCode();
		
		return result;
		
	}
}
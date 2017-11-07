package com.mchange.v2.c3p0.impl;

import com.mchange.v2.c3p0.C3P0Registry;
import com.mchange.v2.c3p0.cfg.C3P0Config;
import com.mchange.v2.c3p0.impl.C3P0Defaults;
import com.mchange.v2.c3p0.impl.C3P0ImplUtils;
import com.mchange.v2.c3p0.impl.IdentityTokenResolvable;
import com.mchange.v2.naming.JavaBeanReferenceMaker;
import com.mchange.v2.naming.ReferenceIndirector;
import com.mchange.v2.ser.IndirectlySerialized;
import com.mchange.v2.ser.SerializableUtils;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;

public class JndiRefDataSourceBase extends IdentityTokenResolvable
		implements
			Referenceable,
			Serializable {
	protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	protected VetoableChangeSupport vcs = new VetoableChangeSupport(this);
	private boolean caching = true;
	private String factoryClassLocation = C3P0Config
			.initializeStringPropertyVar("factoryClassLocation",
					C3P0Defaults.factoryClassLocation());
	private String identityToken;
	private Hashtable jndiEnv;
	private Object jndiName;
	private static final long serialVersionUID = 1L;
	private static final short VERSION = 1;
	static final JavaBeanReferenceMaker referenceMaker = new JavaBeanReferenceMaker();

	protected PropertyChangeSupport getPropertyChangeSupport() {
		return this.pcs;
	}

	protected VetoableChangeSupport getVetoableChangeSupport() {
		return this.vcs;
	}

	public boolean isCaching() {
		return this.caching;
	}

	public void setCaching(boolean caching) {
		boolean oldVal = this.caching;
		this.caching = caching;
		if (oldVal != caching) {
			this.pcs.firePropertyChange("caching", oldVal, caching);
		}

	}

	public String getFactoryClassLocation() {
		return this.factoryClassLocation;
	}

	public void setFactoryClassLocation(String factoryClassLocation) {
		String oldVal = this.factoryClassLocation;
		this.factoryClassLocation = factoryClassLocation;
		if (!this.eqOrBothNull(oldVal, factoryClassLocation)) {
			this.pcs.firePropertyChange("factoryClassLocation", oldVal,
					factoryClassLocation);
		}

	}

	public synchronized String getIdentityToken() {
		return this.identityToken;
	}

	public synchronized void setIdentityToken(String identityToken) {
		String oldVal = this.identityToken;
		this.identityToken = identityToken;
		if (!this.eqOrBothNull(oldVal, identityToken)) {
			this.pcs.firePropertyChange("identityToken", oldVal, identityToken);
		}

	}

	public Hashtable getJndiEnv() {
		return this.jndiEnv != null ? (Hashtable) this.jndiEnv.clone() : null;
	}

	public void setJndiEnv(Hashtable jndiEnv) {
		Hashtable oldVal = this.jndiEnv;
		this.jndiEnv = jndiEnv != null ? (Hashtable) jndiEnv.clone() : null;
		if (!this.eqOrBothNull(oldVal, jndiEnv)) {
			this.pcs.firePropertyChange("jndiEnv", oldVal, jndiEnv);
		}

	}

	public Object getJndiName() {
		return this.jndiName instanceof Name
				? ((Name) this.jndiName).clone()
				: this.jndiName;
	}

	public void setJndiName(Object jndiName) throws PropertyVetoException {
		Object oldVal = this.jndiName;
		if (!this.eqOrBothNull(oldVal, jndiName)) {
			this.vcs.fireVetoableChange("jndiName", oldVal, jndiName);
		}

		this.jndiName = jndiName instanceof Name
				? ((Name) jndiName).clone()
				: jndiName;
		if (!this.eqOrBothNull(oldVal, jndiName)) {
			this.pcs.firePropertyChange("jndiName", oldVal, jndiName);
		}

	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(pcl);
	}

	public void addPropertyChangeListener(String propName,
			PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(propName, pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.removePropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(String propName,
			PropertyChangeListener pcl) {
		this.pcs.removePropertyChangeListener(propName, pcl);
	}

	public void addVetoableChangeListener(VetoableChangeListener vcl) {
		this.vcs.addVetoableChangeListener(vcl);
	}

	public void removeVetoableChangeListener(VetoableChangeListener vcl) {
		this.vcs.removeVetoableChangeListener(vcl);
	}

	private boolean eqOrBothNull(Object a, Object b) {
		return a == b || a != null && a.equals(b);
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeShort(1);
		oos.writeBoolean(this.caching);
		oos.writeObject(this.factoryClassLocation);
		oos.writeObject(this.identityToken);
		oos.writeObject(this.jndiEnv);

		try {
			SerializableUtils.toByteArray(this.jndiName);
			oos.writeObject(this.jndiName);
		} catch (NotSerializableException arg5) {
			try {
				ReferenceIndirector indirectionOtherException = new ReferenceIndirector();
				oos.writeObject(indirectionOtherException
						.indirectForm(this.jndiName));
			} catch (IOException arg3) {
				throw arg3;
			} catch (Exception arg4) {
				throw new IOException(
						"Problem indirectly serializing jndiName: "
								+ arg4.toString());
			}
		}

	}

	private void readObject(ObjectInputStream ois) throws IOException,
			ClassNotFoundException {
		short version = ois.readShort();
		switch (version) {
			case 1 :
				this.caching = ois.readBoolean();
				this.factoryClassLocation = (String) ois.readObject();
				this.identityToken = (String) ois.readObject();
				this.jndiEnv = (Hashtable) ois.readObject();
				Object o = ois.readObject();
				if (o instanceof IndirectlySerialized) {
					o = ((IndirectlySerialized) o).getObject();
				}

				this.jndiName = o;
				this.pcs = new PropertyChangeSupport(this);
				this.vcs = new VetoableChangeSupport(this);
				return;
			default :
				throw new IOException("Unsupported Serialized Version: "
						+ version);
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append(" [ ");
		sb.append("caching -> " + this.caching);
		sb.append(", ");
		sb.append("factoryClassLocation -> " + this.factoryClassLocation);
		sb.append(", ");
		sb.append("identityToken -> " + this.identityToken);
		sb.append(", ");
		sb.append("jndiEnv -> " + this.jndiEnv);
		sb.append(", ");
		sb.append("jndiName -> " + this.jndiName);
		String extraToStringInfo = this.extraToStringInfo();
		if (extraToStringInfo != null) {
			sb.append(extraToStringInfo);
		}

		sb.append(" ]");
		return sb.toString();
	}

	protected String extraToStringInfo() {
		return null;
	}

	public Reference getReference() throws NamingException {
		return referenceMaker.createReference(this);
	}

	private JndiRefDataSourceBase() {
	}

	public JndiRefDataSourceBase(boolean autoregister) {
		if (autoregister) {
			this.identityToken = C3P0ImplUtils.allocateIdentityToken(this);
			C3P0Registry.reregister(this);
		}

	}

	static {
		referenceMaker
				.setFactoryClassName("com.mchange.v2.c3p0.impl.C3P0JavaBeanObjectFactory");
		referenceMaker.addReferenceProperty("caching");
		referenceMaker.addReferenceProperty("factoryClassLocation");
		referenceMaker.addReferenceProperty("identityToken");
		referenceMaker.addReferenceProperty("jndiEnv");
		referenceMaker.addReferenceProperty("jndiName");
	}
}
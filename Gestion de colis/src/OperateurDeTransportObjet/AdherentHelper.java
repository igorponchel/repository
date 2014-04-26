package OperateurDeTransportObjet;

/** 
 * Helper class for : Adherent
 *  
 * @author OpenORB Compiler
 */ 
public class AdherentHelper
{
    /**
     * Insert Adherent into an any
     * @param a an any
     * @param t Adherent value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.Adherent t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Adherent from an any
     * @param a an any
     * @return the extracted Adherent value
     */
    public static OperateurDeTransportObjet.Adherent extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return OperateurDeTransportObjet.AdherentHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Adherent TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Adherent");
        }
        return _tc;
    }

    /**
     * Return the Adherent IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/Adherent:1.0";

    /**
     * Read Adherent from a marshalled stream
     * @param istream the input stream
     * @return the readed Adherent value
     */
    public static OperateurDeTransportObjet.Adherent read(org.omg.CORBA.portable.InputStream istream)
    {
        return(OperateurDeTransportObjet.Adherent)istream.read_Object(OperateurDeTransportObjet._AdherentStub.class);
    }

    /**
     * Write Adherent into a marshalled stream
     * @param ostream the output stream
     * @param value Adherent value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.Adherent value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Adherent
     * @param obj the CORBA Object
     * @return Adherent Object
     */
    public static Adherent narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Adherent)
            return (Adherent)obj;

        if (obj._is_a(id()))
        {
            _AdherentStub stub = new _AdherentStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Adherent
     * @param obj the CORBA Object
     * @return Adherent Object
     */
    public static Adherent unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Adherent)
            return (Adherent)obj;

        _AdherentStub stub = new _AdherentStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}

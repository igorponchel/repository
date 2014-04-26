package OperateurDeTransportObjet;

/** 
 * Helper class for : Transporteur
 *  
 * @author OpenORB Compiler
 */ 
public class TransporteurHelper
{
    /**
     * Insert Transporteur into an any
     * @param a an any
     * @param t Transporteur value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.Transporteur t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Transporteur from an any
     * @param a an any
     * @return the extracted Transporteur value
     */
    public static OperateurDeTransportObjet.Transporteur extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return OperateurDeTransportObjet.TransporteurHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Transporteur TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Transporteur");
        }
        return _tc;
    }

    /**
     * Return the Transporteur IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/Transporteur:1.0";

    /**
     * Read Transporteur from a marshalled stream
     * @param istream the input stream
     * @return the readed Transporteur value
     */
    public static OperateurDeTransportObjet.Transporteur read(org.omg.CORBA.portable.InputStream istream)
    {
        return(OperateurDeTransportObjet.Transporteur)istream.read_Object(OperateurDeTransportObjet._TransporteurStub.class);
    }

    /**
     * Write Transporteur into a marshalled stream
     * @param ostream the output stream
     * @param value Transporteur value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.Transporteur value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Transporteur
     * @param obj the CORBA Object
     * @return Transporteur Object
     */
    public static Transporteur narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Transporteur)
            return (Transporteur)obj;

        if (obj._is_a(id()))
        {
            _TransporteurStub stub = new _TransporteurStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Transporteur
     * @param obj the CORBA Object
     * @return Transporteur Object
     */
    public static Transporteur unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Transporteur)
            return (Transporteur)obj;

        _TransporteurStub stub = new _TransporteurStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}

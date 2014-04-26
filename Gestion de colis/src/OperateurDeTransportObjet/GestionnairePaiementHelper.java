package OperateurDeTransportObjet;

/** 
 * Helper class for : GestionnairePaiement
 *  
 * @author OpenORB Compiler
 */ 
public class GestionnairePaiementHelper
{
    /**
     * Insert GestionnairePaiement into an any
     * @param a an any
     * @param t GestionnairePaiement value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.GestionnairePaiement t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionnairePaiement from an any
     * @param a an any
     * @return the extracted GestionnairePaiement value
     */
    public static OperateurDeTransportObjet.GestionnairePaiement extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return OperateurDeTransportObjet.GestionnairePaiementHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionnairePaiement TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionnairePaiement");
        }
        return _tc;
    }

    /**
     * Return the GestionnairePaiement IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/GestionnairePaiement:1.0";

    /**
     * Read GestionnairePaiement from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionnairePaiement value
     */
    public static OperateurDeTransportObjet.GestionnairePaiement read(org.omg.CORBA.portable.InputStream istream)
    {
        return(OperateurDeTransportObjet.GestionnairePaiement)istream.read_Object(OperateurDeTransportObjet._GestionnairePaiementStub.class);
    }

    /**
     * Write GestionnairePaiement into a marshalled stream
     * @param ostream the output stream
     * @param value GestionnairePaiement value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.GestionnairePaiement value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionnairePaiement
     * @param obj the CORBA Object
     * @return GestionnairePaiement Object
     */
    public static GestionnairePaiement narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnairePaiement)
            return (GestionnairePaiement)obj;

        if (obj._is_a(id()))
        {
            _GestionnairePaiementStub stub = new _GestionnairePaiementStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionnairePaiement
     * @param obj the CORBA Object
     * @return GestionnairePaiement Object
     */
    public static GestionnairePaiement unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnairePaiement)
            return (GestionnairePaiement)obj;

        _GestionnairePaiementStub stub = new _GestionnairePaiementStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}

package OperateurDeTransportObjet;

/** 
 * Helper class for : GestionUtilisateurs
 *  
 * @author OpenORB Compiler
 */ 
public class GestionUtilisateursHelper
{
    /**
     * Insert GestionUtilisateurs into an any
     * @param a an any
     * @param t GestionUtilisateurs value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.GestionUtilisateurs t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionUtilisateurs from an any
     * @param a an any
     * @return the extracted GestionUtilisateurs value
     */
    public static OperateurDeTransportObjet.GestionUtilisateurs extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return OperateurDeTransportObjet.GestionUtilisateursHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionUtilisateurs TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionUtilisateurs");
        }
        return _tc;
    }

    /**
     * Return the GestionUtilisateurs IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/GestionUtilisateurs:1.0";

    /**
     * Read GestionUtilisateurs from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionUtilisateurs value
     */
    public static OperateurDeTransportObjet.GestionUtilisateurs read(org.omg.CORBA.portable.InputStream istream)
    {
        return(OperateurDeTransportObjet.GestionUtilisateurs)istream.read_Object(OperateurDeTransportObjet._GestionUtilisateursStub.class);
    }

    /**
     * Write GestionUtilisateurs into a marshalled stream
     * @param ostream the output stream
     * @param value GestionUtilisateurs value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.GestionUtilisateurs value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionUtilisateurs
     * @param obj the CORBA Object
     * @return GestionUtilisateurs Object
     */
    public static GestionUtilisateurs narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionUtilisateurs)
            return (GestionUtilisateurs)obj;

        if (obj._is_a(id()))
        {
            _GestionUtilisateursStub stub = new _GestionUtilisateursStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionUtilisateurs
     * @param obj the CORBA Object
     * @return GestionUtilisateurs Object
     */
    public static GestionUtilisateurs unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionUtilisateurs)
            return (GestionUtilisateurs)obj;

        _GestionUtilisateursStub stub = new _GestionUtilisateursStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}

package OperateurDeTransportObjet;

/** 
 * Helper class for : GestionnaireTransportObjet
 *  
 * @author OpenORB Compiler
 */ 
public class GestionnaireTransportObjetHelper
{
    /**
     * Insert GestionnaireTransportObjet into an any
     * @param a an any
     * @param t GestionnaireTransportObjet value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.GestionnaireTransportObjet t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionnaireTransportObjet from an any
     * @param a an any
     * @return the extracted GestionnaireTransportObjet value
     */
    public static OperateurDeTransportObjet.GestionnaireTransportObjet extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return OperateurDeTransportObjet.GestionnaireTransportObjetHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionnaireTransportObjet TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionnaireTransportObjet");
        }
        return _tc;
    }

    /**
     * Return the GestionnaireTransportObjet IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/GestionnaireTransportObjet:1.0";

    /**
     * Read GestionnaireTransportObjet from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionnaireTransportObjet value
     */
    public static OperateurDeTransportObjet.GestionnaireTransportObjet read(org.omg.CORBA.portable.InputStream istream)
    {
        return(OperateurDeTransportObjet.GestionnaireTransportObjet)istream.read_Object(OperateurDeTransportObjet._GestionnaireTransportObjetStub.class);
    }

    /**
     * Write GestionnaireTransportObjet into a marshalled stream
     * @param ostream the output stream
     * @param value GestionnaireTransportObjet value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.GestionnaireTransportObjet value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionnaireTransportObjet
     * @param obj the CORBA Object
     * @return GestionnaireTransportObjet Object
     */
    public static GestionnaireTransportObjet narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnaireTransportObjet)
            return (GestionnaireTransportObjet)obj;

        if (obj._is_a(id()))
        {
            _GestionnaireTransportObjetStub stub = new _GestionnaireTransportObjetStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionnaireTransportObjet
     * @param obj the CORBA Object
     * @return GestionnaireTransportObjet Object
     */
    public static GestionnaireTransportObjet unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnaireTransportObjet)
            return (GestionnaireTransportObjet)obj;

        _GestionnaireTransportObjetStub stub = new _GestionnaireTransportObjetStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}

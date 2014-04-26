package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/** 
 * Helper class for : EtatObjet
 *  
 * @author OpenORB Compiler
 */ 
public class EtatObjetHelper
{
    /**
     * Insert EtatObjet into an any
     * @param a an any
     * @param t EtatObjet value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract EtatObjet from an any
     * @param a an any
     * @return the extracted EtatObjet value
     */
    public static OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the EtatObjet TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[4];
            _members[0] = "depose";
            _members[1] = "enTransit";
            _members[2] = "livre";
            _members[3] = "delivre";
            _tc = orb.create_enum_tc(id(),"EtatObjet",_members);
        }
        return _tc;
    }

    /**
     * Return the EtatObjet IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/GestionnaireTransportObjet/EtatObjet:1.0";

    /**
     * Read EtatObjet from a marshalled stream
     * @param istream the input stream
     * @return the readed EtatObjet value
     */
    public static OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet read(org.omg.CORBA.portable.InputStream istream)
    {
        return EtatObjet.from_int(istream.read_ulong());
    }

    /**
     * Write EtatObjet into a marshalled stream
     * @param ostream the output stream
     * @param value EtatObjet value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet value)
    {
        ostream.write_ulong(value.value());
    }

}

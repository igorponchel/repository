package OperateurDeTransportObjet.StationPackage;

/** 
 * Helper class for : EtatCasier
 *  
 * @author OpenORB Compiler
 */ 
public class EtatCasierHelper
{
    /**
     * Insert EtatCasier into an any
     * @param a an any
     * @param t EtatCasier value
     */
    public static void insert(org.omg.CORBA.Any a, OperateurDeTransportObjet.StationPackage.EtatCasier t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract EtatCasier from an any
     * @param a an any
     * @return the extracted EtatCasier value
     */
    public static OperateurDeTransportObjet.StationPackage.EtatCasier extract(org.omg.CORBA.Any a)
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
     * Return the EtatCasier TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[2];
            _members[0] = "vide";
            _members[1] = "occupe";
            _tc = orb.create_enum_tc(id(),"EtatCasier",_members);
        }
        return _tc;
    }

    /**
     * Return the EtatCasier IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:OperateurDeTransportObjet/Station/EtatCasier:1.0";

    /**
     * Read EtatCasier from a marshalled stream
     * @param istream the input stream
     * @return the readed EtatCasier value
     */
    public static OperateurDeTransportObjet.StationPackage.EtatCasier read(org.omg.CORBA.portable.InputStream istream)
    {
        return EtatCasier.from_int(istream.read_ulong());
    }

    /**
     * Write EtatCasier into a marshalled stream
     * @param ostream the output stream
     * @param value EtatCasier value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, OperateurDeTransportObjet.StationPackage.EtatCasier value)
    {
        ostream.write_ulong(value.value());
    }

}

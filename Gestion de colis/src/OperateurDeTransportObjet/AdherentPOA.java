package OperateurDeTransportObjet;

/**
 * Interface definition : Adherent
 * 
 * @author OpenORB Compiler
 */
public abstract class AdherentPOA extends org.omg.PortableServer.Servant
        implements AdherentOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Adherent _this()
    {
        return AdherentHelper.narrow(_this_object());
    }

    public Adherent _this(org.omg.CORBA.ORB orb)
    {
        return AdherentHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/Adherent:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("notifierColisArrive")) {
                return _invoke_notifierColisArrive(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_notifierColisArrive(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();

        notifierColisArrive(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}

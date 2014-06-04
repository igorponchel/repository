package OperateurDeTransportObjet;

/**
 * Interface definition : Station
 * 
 * @author OpenORB Compiler
 */
public abstract class StationPOA extends org.omg.PortableServer.Servant
        implements StationOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Station _this()
    {
        return StationHelper.narrow(_this_object());
    }

    public Station _this(org.omg.CORBA.ORB orb)
    {
        return StationHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/Station:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("reserverCasier")) {
                return _invoke_reserverCasier(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_reserverCasier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            int _arg_result = reserverCasier(arg0_in);

            _output = handler.createReply();
            _output.write_long(_arg_result);

        }
        catch (OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleException _exception)
        {
            _output = handler.createExceptionReply();
            OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

}

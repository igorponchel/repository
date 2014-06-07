package OperateurDeTransportObjet;

/**
 * Interface definition : Station
 * 
 * @author OpenORB Compiler
 */
public class _StationStub extends org.omg.CORBA.portable.ObjectImpl
        implements Station
{
    static final String[] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/Station:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = OperateurDeTransportObjet.StationOperations.class;

    /**
     * Operation reserverCasier
     */
    public int reserverCasier(int numeroAdherent)
        throws OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("reserverCasier",true);
                    _output.write_long(numeroAdherent);
                    _input = this._invoke(_output);
                    int _arg_ret = _input.read_long();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleExceptionHelper.id()))
                    {
                        throw OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleExceptionHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("reserverCasier",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.StationOperations _self = (OperateurDeTransportObjet.StationOperations) _so.servant;
                try
                {
                    return _self.reserverCasier( numeroAdherent);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation notifierCodeTransport
     */
    public void notifierCodeTransport(int numeroCasier, String codeTransport)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierCodeTransport",false);
                    _output.write_long(numeroCasier);
                    _output.write_string(codeTransport);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifierCodeTransport",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.StationOperations _self = (OperateurDeTransportObjet.StationOperations) _so.servant;
                try
                {
                    _self.notifierCodeTransport( numeroCasier,  codeTransport);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}

package OperateurDeTransportObjet;

/**
 * Interface definition : Adherent
 * 
 * @author OpenORB Compiler
 */
public class _AdherentStub extends org.omg.CORBA.portable.ObjectImpl
        implements Adherent
{
    static final String[] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/Adherent:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = OperateurDeTransportObjet.AdherentOperations.class;

    /**
     * Operation notifierColisArrive
     */
    public void notifierColisArrive(int numeroObjet)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierColisArrive",false);
                    _output.write_long(numeroObjet);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifierColisArrive",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.AdherentOperations _self = (OperateurDeTransportObjet.AdherentOperations) _so.servant;
                try
                {
                    _self.notifierColisArrive( numeroObjet);
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

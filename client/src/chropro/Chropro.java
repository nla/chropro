package chropro;

import java.io.Closeable;
import java.io.IOException;
import java.lang.String;

public class Chropro implements Closeable {
  public final RpcClient rpcClient;

  public final InspectorDomain inspector;

  public final MemoryDomain memory;

  public final PageDomain page;

  public final RenderingDomain rendering;

  public final EmulationDomain emulation;

  public final SecurityDomain security;

  public final NetworkDomain network;

  public final DatabaseDomain database;

  public final IndexedDBDomain indexedDB;

  public final CacheStorageDomain cacheStorage;

  public final DOMStorageDomain domstorage;

  public final ApplicationCacheDomain applicationCache;

  public final DOMDomain dom;

  public final CSSDomain css;

  public final IODomain io;

  public final DOMDebuggerDomain domdebugger;

  public final TargetDomain target;

  public final ServiceWorkerDomain serviceWorker;

  public final InputDomain input;

  public final LayerTreeDomain layerTree;

  public final DeviceOrientationDomain deviceOrientation;

  public final TracingDomain tracing;

  public final AnimationDomain animation;

  public final AccessibilityDomain accessibility;

  public final StorageDomain storage;

  public final LogDomain log;

  public final SystemInfoDomain systemInfo;

  public final TetheringDomain tethering;

  public final SchemaDomain schema;

  public final RuntimeDomain runtime;

  public final DebuggerDomain debugger;

  public final ConsoleDomain console;

  public final ProfilerDomain profiler;

  public final HeapProfilerDomain heapProfiler;

  public Chropro(String webSocketDebuggerUrl) throws IOException {
    this(new RpcClient(webSocketDebuggerUrl));
  }

  public Chropro(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
    inspector = new InspectorDomain(rpcClient);
    memory = new MemoryDomain(rpcClient);
    page = new PageDomain(rpcClient);
    rendering = new RenderingDomain(rpcClient);
    emulation = new EmulationDomain(rpcClient);
    security = new SecurityDomain(rpcClient);
    network = new NetworkDomain(rpcClient);
    database = new DatabaseDomain(rpcClient);
    indexedDB = new IndexedDBDomain(rpcClient);
    cacheStorage = new CacheStorageDomain(rpcClient);
    domstorage = new DOMStorageDomain(rpcClient);
    applicationCache = new ApplicationCacheDomain(rpcClient);
    dom = new DOMDomain(rpcClient);
    css = new CSSDomain(rpcClient);
    io = new IODomain(rpcClient);
    domdebugger = new DOMDebuggerDomain(rpcClient);
    target = new TargetDomain(rpcClient);
    serviceWorker = new ServiceWorkerDomain(rpcClient);
    input = new InputDomain(rpcClient);
    layerTree = new LayerTreeDomain(rpcClient);
    deviceOrientation = new DeviceOrientationDomain(rpcClient);
    tracing = new TracingDomain(rpcClient);
    animation = new AnimationDomain(rpcClient);
    accessibility = new AccessibilityDomain(rpcClient);
    storage = new StorageDomain(rpcClient);
    log = new LogDomain(rpcClient);
    systemInfo = new SystemInfoDomain(rpcClient);
    tethering = new TetheringDomain(rpcClient);
    schema = new SchemaDomain(rpcClient);
    runtime = new RuntimeDomain(rpcClient);
    debugger = new DebuggerDomain(rpcClient);
    console = new ConsoleDomain(rpcClient);
    profiler = new ProfilerDomain(rpcClient);
    heapProfiler = new HeapProfilerDomain(rpcClient);
  }

  public void close() throws IOException {
    rpcClient.close();
  }
}

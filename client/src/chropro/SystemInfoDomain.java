package chropro;

import java.lang.Double;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Generated;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:00:26.964Z"
)
public class SystemInfoDomain {
  private RpcClient rpcClient;

  public SystemInfoDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Returns information about the system.
   */
  public CompletableFuture<GetInfo> getInfo() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("SystemInfo.getInfo", params, GetInfo.class);
  }

  /**
   * Describes a single graphics processor (GPU).
   */
  public static class GPUDevice {
    /**
     * PCI ID of the GPU vendor, if available; 0 otherwise.
     */
    public Double vendorId;

    /**
     * PCI ID of the GPU device, if available; 0 otherwise.
     */
    public Double deviceId;

    /**
     * String description of the GPU vendor, if the PCI ID is not available.
     */
    public String vendorString;

    /**
     * String description of the GPU device, if the PCI ID is not available.
     */
    public String deviceString;

    public String toString() {
      return "GPUDevice{vendorId=" + vendorId + ", deviceId=" + deviceId + ", vendorString=" + vendorString + ", deviceString=" + deviceString + "}";
    }
  }

  /**
   * Provides information about the GPU(s) on the system.
   */
  public static class GPUInfo {
    /**
     * The graphics devices on the system. Element 0 is the primary GPU.
     */
    public List<GPUDevice> devices;

    /**
     * An optional dictionary of additional GPU related attributes.
     */
    public Map<String, Object> auxAttributes;

    /**
     * An optional dictionary of graphics features and their status.
     */
    public Map<String, Object> featureStatus;

    /**
     * An optional array of GPU driver bug workarounds.
     */
    public List<String> driverBugWorkarounds;

    public String toString() {
      return "GPUInfo{devices=" + devices + ", auxAttributes=" + auxAttributes + ", featureStatus=" + featureStatus + ", driverBugWorkarounds=" + driverBugWorkarounds + "}";
    }
  }

  public static class GetInfo {
    /**
     * Information about the GPUs on the system.
     */
    public GPUInfo gpu;

    /**
     * A platform-dependent description of the model of the machine. On Mac OS, this is, for example, 'MacBookPro'. Will be the empty string if not supported.
     */
    public String modelName;

    /**
     * A platform-dependent description of the version of the machine. On Mac OS, this is, for example, '10.1'. Will be the empty string if not supported.
     */
    public String modelVersion;

    public String toString() {
      return "GetInfo{gpu=" + gpu + ", modelName=" + modelName + ", modelVersion=" + modelVersion + "}";
    }
  }
}

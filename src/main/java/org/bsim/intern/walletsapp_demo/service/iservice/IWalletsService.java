package org.bsim.intern.walletsapp_demo.service.iservice;


import org.bsim.intern.walletsapp_demo.shared.dto.WalletsDTO;

import java.util.List;

public interface IWalletsService {
    List<WalletsDTO> getAllWalletsData(String userid);
    long getTotalBalance(String userid);
    WalletsDTO addNewWalletData(String userid, WalletsDTO walletsDTO);
    WalletsDTO updateWalletData(String userid, String walletid, WalletsDTO walletsDTO);
}

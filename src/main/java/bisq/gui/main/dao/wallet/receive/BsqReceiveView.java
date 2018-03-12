/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.gui.main.dao.wallet.receive;

import bisq.core.btc.wallet.BsqWalletService;

import bisq.common.locale.Res;

import javax.inject.Inject;

import javafx.scene.layout.GridPane;

import static bisq.gui.util.FormBuilder.addLabelBsqAddressTextField;
import static bisq.gui.util.FormBuilder.addTitledGroupBg;



import bisq.gui.common.view.ActivatableView;
import bisq.gui.common.view.FxmlView;
import bisq.gui.components.BsqAddressTextField;
import bisq.gui.main.dao.wallet.BsqBalanceUtil;
import bisq.gui.util.BsqFormatter;
import bisq.gui.util.Layout;

@FxmlView
public class BsqReceiveView extends ActivatableView<GridPane, Void> {

    private BsqAddressTextField addressTextField;
    private final BsqWalletService bsqWalletService;
    private final BsqFormatter bsqFormatter;
    private final BsqBalanceUtil bsqBalanceUtil;
    private final String paymentLabelString;
    private int gridRow = 0;


    ///////////////////////////////////////////////////////////////////////////////////////////
    // Constructor, lifecycle
    ///////////////////////////////////////////////////////////////////////////////////////////

    @Inject
    private BsqReceiveView(BsqWalletService bsqWalletService, BsqFormatter bsqFormatter, BsqBalanceUtil bsqBalanceUtil) {
        this.bsqWalletService = bsqWalletService;
        this.bsqFormatter = bsqFormatter;
        this.bsqBalanceUtil = bsqBalanceUtil;
        paymentLabelString = Res.get("dao.wallet.receive.fundBSQWallet");
    }

    @Override
    public void initialize() {
        gridRow = bsqBalanceUtil.addGroup(root, gridRow);

        addTitledGroupBg(root, ++gridRow, 1, Res.get("dao.wallet.receive.fundYourWallet"), Layout.GROUP_DISTANCE);

        addressTextField = addLabelBsqAddressTextField(root, gridRow, Res.getWithCol("shared.address"),
                Layout.FIRST_ROW_AND_GROUP_DISTANCE).second;
        addressTextField.setPaymentLabel(paymentLabelString);
    }

    @Override
    protected void activate() {
        bsqBalanceUtil.activate();

        addressTextField.setAddress(bsqFormatter.getBsqAddressStringFromAddress(bsqWalletService.getUnusedAddress()));
    }

    @Override
    protected void deactivate() {
        bsqBalanceUtil.deactivate();
    }
}

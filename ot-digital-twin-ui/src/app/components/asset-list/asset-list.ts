import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AssetService } from '../../services/asset.service';
import { Asset } from '../../models/asset';

@Component({
  selector: 'app-asset-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './asset-list.html',
  styleUrls: ['./asset-list.css']
})
export class AssetListComponent {
  
  assets$;

  constructor(private assetService: AssetService) {
    this.assets$ = this.assetService.assets$;
  }
}
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { AssetService } from '../../services/asset.service';
import { Asset } from '../../models/asset';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-asset-details',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './asset-details.html',
  styleUrls: ['./asset-details.css']
})
export class AssetDetailsComponent implements OnInit {

  asset$: Observable<Asset | undefined> | undefined;

  constructor(
    private route: ActivatedRoute,
    private assetService: AssetService
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    
    this.asset$ = this.assetService.getAssetById(id);
  }
}